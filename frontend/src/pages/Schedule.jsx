import React from "react";
import Rehearsals from "../components/content/Rehearsals/Rehearsals.jsx";

export default function Schedule() {
  return (
    <div>
      <div className="header">Schedule</div>
      <div className="placeholder">
        <p>Here you can view and edit upcoming rehearsals.</p>
      </div>
      <Rehearsals />
    </div>
  );
}
