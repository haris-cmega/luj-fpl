import axios from "axios";

import { useState, useEffect } from "react";

function Deadline() {
  const [deadline, setDeadline] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/deadline")
      .then((response) => {
        const formatted = formatDeadline(response.data);
        setDeadline(formatted);
      })
      .catch((error) => {
        console.log(
          "There was an error attempting to fetch deadline data: " + error
        );
      });
  }, []);

  function formatDeadline(utcDateString) {
    const date = new Date(utcDateString);
    return date.toLocaleString("sq-AL", {
      timeZone: "Europe/Belgrade",
      weekday: "long",
      day: "numeric",
      month: "long",
      year: "numeric",
      hour: "2-digit",
      minute: "2-digit",
      hour12: false,
    });
  }

  return (
    <>
      <div className="card bg-error-content w-96 card-xl shadow-xl m-3">
        <div className="card-body">
          <h1 className="card-title">DEADLINE ⚠️</h1>
          <h3>Ke kohe me ndrru ekipin deri:</h3>
          <p>
            <b>{deadline}</b>
          </p>
        </div>
      </div>
    </>
  );
}

export default Deadline;
