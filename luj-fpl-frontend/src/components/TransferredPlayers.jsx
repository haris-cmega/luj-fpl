import { useState, useEffect } from "react";

function TransferredPlayers() {
  const [transferredInPlayers, setTransferredInPlayers] = useState([]);
  const [transferredOutPlayers, setTransferredOutPlayers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchTransfers = async () => {
      try {
        const [inRes, outRes] = await Promise.all([
          fetch("http://localhost:8080/api/mostTransferredIn"),
          fetch("http://localhost:8080/api/mostTransferredOut"),
        ]);

        const inData = await inRes.json();
        const outData = await outRes.json();

        setTransferredInPlayers(inData);
        setTransferredOutPlayers(outData);
        setLoading(false);
      } catch (error) {
        console.error("Failed to fetch transfer data:", error);
        setLoading(false);
      }
    };

    fetchTransfers();
  }, []);

  if (loading)
    return <p className="text-center mt-8">Loading transfer data...</p>;

  const renderTable = (players, title) => (
    <div className="mb-12">
      <h2 className="text-xl font-semibold mb-4 text-center text-error-content">
        {title}
      </h2>
      <div className="max-w-3xl mx-auto">
        <div className="overflow-x-auto rounded-box border border-base-content/5 transferet text-base-300 p-3 flex justify-center">
          <table className="table-auto w-auto text-base border border-gray-300 shadow-lg rounded">
            <thead>
              <tr className="text-base-300">
                <th className="px-4 py-3">Emri</th>
                <th className="px-4 py-3">Cmimi</th>
                <th className="px-4 py-3">Totali i pikeve</th>
                <th className="px-4 py-3">Transferimet</th>
              </tr>
            </thead>
            <tbody>
              {players.map((player, index) => (
                <tr key={index} className="border-b border-gray-300">
                  <td className="px-6 py-3">{player.name}</td>
                  <td className="px-6 py-3">{player.price.toFixed(1)} £</td>
                  <td className="px-6 py-3">{player.totalPoints}</td>
                  <td className="px-6 py-3">
                    {player.transfers.toLocaleString()}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );

  return (
    <div className="px-4 py-8 flex flex-col md:flex-row mt-5 justify-center gap-8">
      {renderTable(transferredInPlayers, "Top 5 të transferuarit 🟢")}
      {renderTable(transferredOutPlayers, "Top 5 të transferuarit jashtë 🔴")}
    </div>
  );
}

export default TransferredPlayers;
