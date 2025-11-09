import React from "react";
import Assignments from "../components/content/Actors/Assignments";

export default function Castings() {
  return (
    <div>
      <div className="header">Castings</div>
      <div className="placeholder">
        <p>Manage your cast members and roles.</p>
      </div>
      <Assignments />
    </div>
  );
}
