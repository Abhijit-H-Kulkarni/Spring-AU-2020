import React from 'react';
import { connect } from 'react-redux';
import { buyCake } from '../redux/cake/cakeActions';
import data from './data';

function CakeContainer(props) {
    const Data = data.map((cur, ind) => {
        return(
            <button style={{width:200+'px',height:100+'px',margin:10+'px'}} key={ind} onClick = {() => props.dispatch(buyCake(('ID : '+cur.id+' City : '+cur.city+' State : '+cur.state+' Country : '+cur.country+'.')))}> ID : {cur.id}</button>
        );
    });

    return (
        <div>
            <h2>Click on any of the below buttons to display state details :</h2>
            { Data }
            <h2>The details of states are as below : <br/> </h2>
            <div style={{width:100+'%', height:50+'px',textAlign:'center',  wordwrap: 'break-word' }}>
                { props.Details }
            </div>
        </div>
    )
}

const mapStateToProps = state =>{
    return {
        Details: state.Details
    }
}

export default connect(mapStateToProps)(CakeContainer); 