import {Injectable} from "@angular/core";
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {SessionService} from "./SessionService";
import {HttpService} from "./HttpService";
import {HttpRequestUrl} from "../constant/HttpRequestUrl";
import {HeadToken} from "../models/token/head.token";

@Injectable()
export class AuthService implements CanActivate {

    constructor(private sessionService:SessionService,
                private httpService:HttpService){

    }

    /** URL路径权限判断 */
    canActivate(route: ActivatedRouteSnapshot,state: RouterStateSnapshot) {
        let sessionData:any = this.sessionService.getSessionData();
        if(sessionData==null){//防止用户清空缓存
            return false;
        }
        let headToken:HeadToken = new HeadToken();
        headToken.token = sessionData.token;
        headToken.userId = sessionData.user.userId;
        headToken.type = sessionData.type;
        this.getRedisUserInfo(headToken);//防止服务器端redis的session失效
        sessionData = this.sessionService.getSessionData();
        if(sessionData==null){
            return false;
        }else{
            let moduleList = sessionData.moduleList;
            if(moduleList==null/*||moduleList.length==0*/){
                return false;
            }
            let url = state.url.split("?")[0];//获得页面请求的URL
            //console.log(url);
            if(url=='/web'){
                return true;
            }else{
                for(let i of moduleList){
                    if(url==i.pageUrl){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** 操作权限判断 */
    canShow(apiUrl:string){
        let sessionData:any = this.sessionService.getSessionData();
        /** 为降低服务器压力，去掉没太大必要的校验
        if(sessionData==null){//防止用户清空缓存
            return false;
        }
        let headToken:HeadToken = new HeadToken();
        headToken.token = sessionData.token;
        headToken.userId = sessionData.user.userId;
        headToken.type = sessionData.type;
        this.getRedisUserInfo(headToken);//防止服务器端redis的session失效
        sessionData = this.sessionService.getSessionData();
        */
        if(sessionData==null){
            return false;
        }else{
            let authOperateList = sessionData.authOperateList;
            if(authOperateList==null/*||authOperateList.length==0*/){
                return false;
            }
            for(let i of authOperateList){
                if(apiUrl==i.apiUrl){
                    return true;
                }
            }
        }
        return false;
    }

    getRedisUserInfo(headToken:HeadToken):void{
        this.httpService.getJsonData(HttpRequestUrl.getPath(HttpRequestUrl.GET_REDIS_USER_INFO,true),headToken).subscribe(
            result => {
                let ret = result.data;
                if(ret==null){
                    this.sessionService.clearSessionData();
                }
            }
        );
    }

}
