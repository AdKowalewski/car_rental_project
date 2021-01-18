
import './InputSearch.css';

import React from "react";
import tank from "../../assets/appImages/local.png"

const InputSearch = (props)=> {
    return(
        <div className={"inputSearchContainer"}>
            <div>{props.name}</div>
            <div className={"inputContainer"}>
                <img className={"imageLoc"} src={tank} alt={"tank"} />
                <input className={"input"} placeholder={props.placeholder}/>
            </div>
        </div>
    )
}

export default InputSearch;
