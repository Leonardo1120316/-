//本地数据存储session
export const SET_SESSION = (session:string) => {
    sessionStorage.setItem("SESSION",session);
}

//本地数据获取session
export const GET_SESSION = () => {
    return sessionStorage.getItem("SESSION");
}

//移除本地session
export const REMOVE_SESSION = () =>{
    return sessionStorage.removeItem('SESSION');
}