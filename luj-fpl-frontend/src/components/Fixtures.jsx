import { useState, useEffect } from "react";
import axios from "axios";

function Fixtures() {
  const [matchDate, setMatchDate] = useState("");
  const [fixtures, setFixtures] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/fixtures")
      .then((response) => {
        const data = response.data;
        setFixtures(data);

        if (data.length > 0) {
          const kickoffDate = new Date(data[0].kickOffTime);
          setMatchDate(
            kickoffDate.toLocaleDateString("sq-AL", {
              timeZone: "Europe/Tirane",
              weekday: "long",
              day: "numeric",
              month: "long",
              year: "numeric",
            })
          );
        }
      })
      .catch((error) => {
        console.error("Error fetching fixtures:", error);
      });
  }, []);

  return (
    <div>
      <h2 className="text-xl font-semibold mb-4 text-center text-error-content">
        Ndeshjet e radhës - {matchDate}
      </h2>
      <div className="max-w-3xl mx-auto">
        <div className="overflow-x-auto rounded-box border border-base-content/5 bg-base text-base-300 p-3 flex justify-center">
          <table className="table-auto w-auto text-base border border-gray-300 shadow-lg rounded">
            <thead>
              <tr className="text-base-300">
                <th className="px-4 py-3">Home Team</th>
                <th className="px-4 py-3">Kick Off</th>
                <th className="px-4 py-3">Away Team</th>
              </tr>
            </thead>
            <tbody>
              {fixtures.map((fixture, index) => (
                <tr key={index} className="border-b border-gray-300">
                  <td className="px-10 py-3">{fixture.homeTeam}</td>
                  <td className="px-5 py-3">
                    {new Date(fixture.kickOffTime).toLocaleTimeString("sq-AL", {
                      timeZone: "Europe/Tirane",
                      hour: "2-digit",
                      minute: "2-digit",
                      hour12: false,
                    })}
                  </td>
                  <td className="px-4 py-3">{fixture.awayTeam}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default Fixtures;
