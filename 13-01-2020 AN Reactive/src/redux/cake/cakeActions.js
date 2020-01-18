import { GET_DETAILS } from './cakeTypes';
export const buyCake = (details)=>{
    return {
        type : GET_DETAILS,
        det : details
    }
}