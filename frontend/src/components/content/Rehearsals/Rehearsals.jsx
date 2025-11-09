import React, { useEffect, useState } from "react";
import { getRehearsals, addRehearsal } from "../../../API/api";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Rehearsals.css";

export default function Rehearsals() {
  const [rehearsals, setRehearsals] = useState([]);
  const [form, setForm] = useState({
    date: "",
    startTime: "",
    endTime: "",
    location: "",
    notes: "",
    play: "",
  });

  // Fetch from backend when component mounts
  useEffect(() => {
    getRehearsals()
      .then((res) => setRehearsals(res.data))
      .catch((err) => console.error("Error fetching rehearsals:", err));
  }, []);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!form.date || !form.startTime || !form.endTime || !form.location)
      return;

    const newRehearsal = {
      date: form.date,
      startTime: form.startTime,
      endTime: form.endTime,
      location: form.location,
      notes: form.notes,
      play: { title: form.play }, // backend expects a Play entity
    };

    addRehearsal(newRehearsal)
      .then((res) => {
        setRehearsals([...rehearsals, res.data]);
        setForm({
          date: "",
          startTime: "",
          endTime: "",
          location: "",
          notes: "",
          play: "",
        });
      })
      .catch((err) => console.error("Error adding rehearsal:", err));
  };

  return (
    <div className="rehearsals-container">
      <h2>Rehearsals</h2>

      <form onSubmit={handleSubmit} className="row g-3 mb-4">
        <div className="col-md-2">
          <input
            type="date"
            name="date"
            className="form-control"
            value={form.date}
            onChange={handleChange}
          />
        </div>
        <div className="col-md-2">
          <input
            type="time"
            name="startTime"
            className="form-control"
            value={form.startTime}
            onChange={handleChange}
            placeholder="Start"
          />
        </div>
        <div className="col-md-2">
          <input
            type="time"
            name="endTime"
            className="form-control"
            value={form.endTime}
            onChange={handleChange}
            placeholder="End"
          />
        </div>
        <div className="col-md-2">
          <input
            type="text"
            name="location"
            className="form-control"
            placeholder="Location"
            value={form.location}
            onChange={handleChange}
          />
        </div>
        <div className="col-md-2">
          <input
            type="text"
            name="play"
            className="form-control"
            placeholder="Play"
            value={form.play}
            onChange={handleChange}
          />
        </div>
        <div className="col-md-2">
          <button type="submit" className="btn btn-primary w-100">
            Add
          </button>
        </div>

        <div className="col-12">
          <textarea
            name="notes"
            className="form-control"
            placeholder="Notes (optional)"
            value={form.notes}
            onChange={handleChange}
          />
        </div>
      </form>

      <table className="table table-striped">
        <thead>
          <tr>
            <th>Date</th>
            <th>Start</th>
            <th>End</th>
            <th>Location</th>
            <th>Play</th>
            <th>Notes</th>
          </tr>
        </thead>
        <tbody>
          {rehearsals.map((r) => (
            <tr key={r.id}>
              <td>{r.date}</td>
              <td>{r.startTime}</td>
              <td>{r.endTime}</td>
              <td>{r.location}</td>
              <td>{r.play?.title || "N/A"}</td>
              <td>{r.notes}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
