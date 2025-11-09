import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";

import Dashboard from "./pages/Dashboard";
import Schedule from "./pages/Schedule";
import Scripts from "./pages/Scripts";
import Castings from "./pages/Castings.jsx";
import Settings from "./pages/Settings";
import "./index.css";
import Sidebar from "./components/Sidebar/Sidebar.jsx";

export default function App() {
  return (
    <Router>
      <div className="app-container">
        <Sidebar />
        <main className="main-content">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/schedule" element={<Schedule />} />
            <Route path="/scripts" element={<Scripts />} />
            <Route path="/castings" element={<Castings />} />
            <Route path="/settings" element={<Settings />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}
