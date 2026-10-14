import { useState } from "react";
import { useNavigate } from "react-router-dom";

function JoinGame (){
    const navigate = useNavigate();

    const [playerName, setPlayerName] = useState("");
    const [roomCode,setRoomCode] = useState("");

    function handleJoinGame() {
        if (!playerName.trim() || !roomCode.trim()) {
            alert("Please enter your name and room code.");
            return;
        }
        console.log("PLayer name: ", playerName.trim());
        console.log("Room code: ", roomCode.trim().toUpperCase());
    }
    return(
            <main className="container">
                <div className="min-vh-100 d-flex align-items-center justify-content-center">
                    <div className="card shadow-sm p-4" style={{maxwidth: "500px", width: "100%"}}>
                        <h2 className="text-center mb-3">
                            Join Game
                        </h2>
                        <div className="mb-3">
                            <label htmlFor="playerName" className="form-label">
                                Your Name
                            </label>
                            <input
                                id="playerName"
                                type="text"                                
                                className="form-control"
                                placeholder="Enter your name"
                                maxLength={20}
                                value={playerName}
                                onChange={(event)=> setPlayerName(event.target.value)}
                            />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="roomCode" className="form-label">
                                Room Code
                            </label>
                            <input
                                id="roomCode"
                                type="text"
                                className="form-control text-uppercase"
                                placeholder="Enter room code"
                                maxLength={6}
                                value={roomCode}
                                onChange={(event)=> setRoomCode(event.target.value)}
                            />
                        </div>
                        <button className="btn btn-primary w-100" onClick={handleJoinGame}>
                            Join Game
                        </button>
                        <button className="btn btn-link w-100 mt-2" onClick={() => navigate("/")}>
                            Back to Home
                        </button>
                    </div>
                </div>
            </main>
    )
}   



export default JoinGame