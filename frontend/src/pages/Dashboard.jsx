import React, { useState } from "react";
import ActorDashboard from "../components/content/Dashboard/ActorDashboard.jsx";
import DirectorDashboard from "../components/content/Dashboard/DirectorDashboard.jsx";
import "../components/content/Dashboard/Dashboard.css";

export default function Dashboard() {
  // Mock toggle for now; later replaced by user role from login
  const [role, setRole] = useState("actor");

  return (
    <div className="dashboard-container mt-4">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h2>Dashboard</h2>
        <select
          className="form-select w-auto"
          value={role}
          onChange={(e) => setRole(e.target.value)}
        >
          <option value="actor">Actor</option>
          <option value="director">Director</option>
        </select>
      </div>

      {role === "actor" && <ActorDashboard />}
      {role === "director" && <DirectorDashboard />}
    </div>
  );
}
