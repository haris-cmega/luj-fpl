import "./App.css";
import Navbar from "./components/Navbar";
import Deadline from "./components/Deadline";
import Fixtures from "./components/Fixtures";

function App() {
  return (
    <>
      <Navbar />
      <div className="flex max-w-7xl mx-auto px-4 mt-4 gap-4">
        <div>
          <Deadline />
        </div>
        <div className="flex-1">
          <Fixtures />
        </div>
      </div>
    </>
  );
}

export default App;
