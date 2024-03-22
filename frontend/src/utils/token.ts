//本地数据存储数据
export const SET_TOKEN = (token:string) => {
    localStorage.setItem("TOKEN",token);
}

//本地数据获取数据
export const GET_TOKEN = () => {
    return localStorage.getItem("TOKEN");
}

//移除本地token
export const REMOVE_TOKEN = () =>{
    return localStorage.removeItem('TOKEN');
}