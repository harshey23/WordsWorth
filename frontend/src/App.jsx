import { useState } from 'react'

import Home from './pages/Home'
import CreateGame from './pages/CreateGame'

import './App.css'

function App() {
  const [currentPage, setCurrentPage] = useState("home")

  function handleCreateGame() {
    setCurrentPage("create")
  }

  function handleBack() {
    setCurrentPage("home")
  }

  return (
    <>
      {currentPage === "home" && <Home onCreateGame={handleCreateGame} />}
      {currentPage === "create" && <CreateGame onBack={handleBack} />}
    </>
  )
}

export default App
