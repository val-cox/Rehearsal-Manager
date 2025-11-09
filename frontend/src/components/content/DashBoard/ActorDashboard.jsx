import React from "react";

export default function ActorDashboard() {
  const mockData = {
    name: "John Doe",
    nextRehearsal: {
      date: "2025-11-12",
      time: "14:00",
      location: "Main Hall",
    },
    roles: ["Hamlet", "Ghost of King Hamlet"],
  };

  return (
    <div>
      <h4>Welcome, {mockData.name} 🎭</h4>

      <div className="dashboard-card">
        <h5>Next Rehearsal</h5>
        <p>
          {mockData.nextRehearsal.date} at {mockData.nextRehearsal.time} —{" "}
          <b>{mockData.nextRehearsal.location}</b>
        </p>
      </div>

      <div className="dashboard-card">
        <h5>Your Roles</h5>
        <ul>
          {mockData.roles.map((role, index) => (
            <li key={index}>{role}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}
