import './CalendarSearch.css';
import React, {useState} from "react";
import DateTimePicker from 'react-datetime-picker';

const CalendarSearch = (props)=> {
    const [selectedDate, handleDateChange] = useState(new Date());
    return(
        <div className={"inputSearchContainer"}>
            <div>{props.name}</div>
                <DateTimePicker value={selectedDate} onChange={handleDateChange} />
        </div>
    )
}

export default CalendarSearch;
