import React, { useEffect, useState } from "react";
import { getAssignments, addAssignment } from "../../../API/api"; // make sure api.js is in src/api/
import "bootstrap/dist/css/bootstrap.min.css";
import "./Assignments.css";

export default function Assignments() {
  const [assignments, setAssignments] = useState([]);
  const [form, setForm] = useState({ actor: "", role: "", assignedDate: "" });

  // Fetch from backend when component mounts
  useEffect(() => {
    getAssignments()
      .then((res) => setAssignments(res.data))
      .catch((err) => console.error("Error fetching assignments:", err));
  }, []);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.actor || !form.role || !form.assignedDate) return;

    const newAssignment = {
      assignedDate: form.assignedDate,
      actor: { name: form.actor }, // assumes backend has an Actor entity
      character: { name: form.role }, // assumes backend has Character entity
    };

    addAssignment(newAssignment)
      .then((res) => {
        setAssignments([...assignments, res.data]);
        setForm({ actor: "", role: "", assignedDate: "" });
      })
      .catch((err) => console.error("Error adding assignment:", err));
  };

  return (
    <div className="assignments-container">
      <h2>Assignments</h2>

      <form onSubmit={handleSubmit} className="row g-3 mb-4">
        <div className="col-md-4">
          <input
            type="text"
            name="actor"
            className="form-control"
            placeholder="Actor Name"
            value={form.actor}
            onChange={handleChange}
          />
        </div>
        <div className="col-md-4">
          <input
            type="text"
            name="role"
            className="form-control"
            placeholder="Role"
            value={form.role}
            onChange={handleChange}
          />
        </div>
        <div className="col-md-3">
          <input
            type="date"
            name="assignedDate"
            className="form-control"
            value={form.assignedDate}
            onChange={handleChange}
          />
        </div>
        <div className="col-md-1">
          <button type="submit" className="btn btn-primary w-100">
            Add
          </button>
        </div>
      </form>

      <table className="table table-striped">
        <thead>
          <tr>
            <th>Actor</th>
            <th>Role</th>
            <th>Assigned Date</th>
          </tr>
        </thead>
        <tbody>
          {assignments.map((a) => (
            <tr key={a.id}>
              <td>{a.actor?.name || "N/A"}</td>
              <td>{a.character?.name || "N/A"}</td>
              <td>{a.assignedDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
