import { Link, useLocation } from "react-router-dom";
import React from "react";

export default function Sidebar() {
  const location = useLocation();
  const isActive = (path) => (location.pathname === path ? "active" : "");

  return (
    <nav className="sidebar">
      <Link to="/" className={isActive("/")}>
        <i className="fa-solid fa-house"></i> Dashboard
      </Link>
      <Link to="/schedule" className={isActive("/schedule")}>
        <i className="fa-solid fa-calendar-days"></i> Schedule
      </Link>
      <Link to="/scripts" className={isActive("/scripts")}>
        <i className="fa-solid fa-scroll"></i> Scripts
      </Link>
      <Link to="/castings" className={isActive("/castings")}>
        <i className="fa-solid fa-users"></i> Castings
      </Link>
      <Link to="/settings" className={isActive("/settings")}>
        <i className="fa-solid fa-gear"></i> Settings
      </Link>
    </nav>
  );
}
