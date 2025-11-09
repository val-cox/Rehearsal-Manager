import React from "react";

export default function Scripts() {
  const plays = [
    {
      id: 1,
      title: "Hamlet",
      author: "Shakespeare",
      premiereDate: "2025-11-20",
    },
    {
      id: 2,
      title: "Les Misérables",
      author: "Victor Hugo",
      premiereDate: "2025-12-01",
    },
  ];

  return (
    <div className="container mt-4">
      <h2>Scripts / Plays</h2>
      <table className="table table-striped mt-3">
        <thead>
          <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Premiere Date</th>
          </tr>
        </thead>
        <tbody>
          {plays.map((p) => (
            <tr key={p.id}>
              <td>{p.title}</td>
              <td>{p.author}</td>
              <td>{p.premiereDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
