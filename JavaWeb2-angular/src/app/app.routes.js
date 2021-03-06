"use strict";
exports.__esModule = true;
var router_1 = require("@angular/router");
var AuthService_1 = require("./service/AuthService");
var login_components_1 = require("./login/login.components");
var home_component_1 = require("./home/home.component");
var user_component_1 = require("./home/user/user.component");
var user_list_component_1 = require("./home/user/list/user.list.component");
var centeral_component_1 = require("./home/centeral/centeral.component");
var user_add_component_1 = require("./home/user/add/user.add.component");
var APP_ROUTES = [
    { path: '', component: login_components_1.LoginComponent },
    { path: 'login', component: login_components_1.LoginComponent },
    { path: 'web', component: home_component_1.HomeComponent, children: [
            { path: '', component: centeral_component_1.CenteralComponent, canActivate: [AuthService_1.AuthService] },
            { path: 'sys/user', component: user_component_1.UserComponent, children: [
                    { path: 'list', component: user_list_component_1.UserListComponent, canActivate: [AuthService_1.AuthService] },
                    { path: 'add', component: user_add_component_1.UserAddComponent, canActivate: [AuthService_1.AuthService] },
                    { path: '**', redirectTo: '/web', pathMatch: 'full' }
                ], canActivate: [AuthService_1.AuthService] },
            { path: '**', redirectTo: '/web', pathMatch: 'full' }
        ], canActivate: [AuthService_1.AuthService] },
    { path: '**', redirectTo: '/', pathMatch: 'full' } //访问任何不存在的URL都将跳回登录页面
];
//路由有两种策略，HashLocationStrategy和PathLocationStrategy，我这里用的是HashLocationStrategy
exports.AppRoutes = router_1.RouterModule.forRoot(APP_ROUTES, { useHash: true });
//# sourceMappingURL=app.routes.js.map