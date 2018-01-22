export class DateUtil{

    public static formatDate(date:any):string{
        if(date.month<10){
            date.month = '0'+date.month;
        }
        if(date.day<10){
            date.day = '0'+date.day;
        }
        return date.year+'-'+date.month+'-'+date.day+' 00:00:00';
    }

}
