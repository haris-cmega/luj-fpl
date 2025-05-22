import axios from 'axios';

import {useState, useEffect} from 'react';

function Deadline(){

    const[deadline, setDeadline] = useState('');

    useEffect(() => {
        axios.get("http://localhost:8080/api/deadline")
        .then((response) => {
            const formatted = formatDeadline(response.data);
            setDeadline(formatted);        
        })
        .catch((error) => {
            console.log("There was an error attempting to fetch deadline data: " + error);
        });
    }, []);

    function formatDeadline(utcDateString) {
        const date = new Date(utcDateString);
        return date.toLocaleString('sq-AL', { 
        timeZone: 'Europe/Belgrade', 
        weekday: 'long',   
        day: 'numeric', 
        month: 'long',    
        year: 'numeric', 
        hour: '2-digit', 
        minute: '2-digit', 
        hour12: false
    });
    
  }

    return(
        <>
        <h1>Deadline</h1>
        <h3>Keni kohe per ndryshime deri:</h3>
        <h4>{deadline}</h4>
        </>
    )
}

export default Deadline;