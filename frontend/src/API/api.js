import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080", // Spring Boot backend
});

// ---- Rehearsals ----
export const getRehearsals = () => api.get("/rehearsals/all");
export const addRehearsal = (rehearsal) => api.post("/rehearsals/add", rehearsal);
export const updateRehearsal = (id, rehearsal) => api.put(`/rehearsals/update/${id}`, rehearsal);
export const deleteRehearsal = (id) => api.delete(`/rehearsals/delete/${id}`);

// ---- Assignments ----
export const getAssignments = () => api.get("/assignments/all");
export const addAssignment = (assignment) => api.post("/assignments/add", assignment);
export const updateAssignment = (id, assignment) => api.put(`/assignments/update/${id}`, assignment);
export const deleteAssignment = (id) => api.delete(`/assignments/delete/${id}`);

export default api;
