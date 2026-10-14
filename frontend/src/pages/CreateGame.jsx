import { useNavigate } from "react-router-dom";

function CreateGame({ onBack }) {
  const navigate = useNavigate();
  return (
    <main className="container">
      <div className="min-vh-100 d-flex align-items-center justify-content-center">

        <div
          className="card shadow-sm p-4"
          style={{ maxWidth: "500px", width: "100%" }}
        >

          <h2 className="text-center mb-4">
            Create Game
          </h2>

          <div className="mb-3">

            <label
              htmlFor="playerName"
              className="form-label"
            >
              Your Name
            </label>

            <input
              type="text"
              id="playerName"
              className="form-control"
              placeholder="Enter your name"
              maxLength="20"
            />

          </div>

          <button className="btn btn-primary w-100">
            Create Lobby
          </button>

          <button
            className="btn btn-link w-100 mt-2"
            onClick={() => navigate("/")}
          >
            Back to Home
          </button>

        </div>

      </div>
    </main>
  )
}

export default CreateGame