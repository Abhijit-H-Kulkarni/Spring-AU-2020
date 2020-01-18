const initialState = {
    Details : ''
};

const cakeReducer = (state=initialState,action)=>{
    if(action.type === 'GET_DETAILS')
        return {...state, Details: action.det}
    return state;
}

export default cakeReducer;