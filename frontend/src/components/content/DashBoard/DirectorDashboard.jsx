import React from "react";

export default function DirectorDashboard() {
  const mockData = {
    nextRehearsal: {
      play: "Hamlet",
      date: "2025-11-12",
      time: "14:00–16:00",
      location: "Main Hall",
    },
    stats: {
      totalActors: 10,
      assignedRoles: 8,
      upcomingRehearsals: 3,
    },
  };

  return (
    <div>
      <h4>Director Overview 🎬</h4>

      <div className="dashboard-card">
        <h5>Next Rehearsal</h5>
        <p>
          <b>{mockData.nextRehearsal.play}</b> — {mockData.nextRehearsal.date} (
          {mockData.nextRehearsal.time})<br />
          Location: <b>{mockData.nextRehearsal.location}</b>
        </p>
      </div>

      <div className="dashboard-stats mt-3">
        <div className="stat-box">
          <h6>Actors</h6>
          <p>{mockData.stats.totalActors}</p>
        </div>
        <div className="stat-box">
          <h6>Roles Assigned</h6>
          <p>{mockData.stats.assignedRoles}</p>
        </div>
        <div className="stat-box">
          <h6>Upcoming Rehearsals</h6>
          <p>{mockData.stats.upcomingRehearsals}</p>
        </div>
      </div>
    </div>
  );
}
