import './App.css'
import { Routes,Route } from 'react-router-dom'

import Home from './pages/Home'
import CreateGame from './pages/CreateGame'
import JoinGame from './pages/JoinGame'


function App() {


  return (

    <Routes>
      <Route path="/" element={<Home  />} />
      <Route path="/create" element={<CreateGame />} />
      <Route path="/join" element={<JoinGame />} />
    </Routes>

  )
}

export default App
