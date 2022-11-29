import './App.css';
import Home from "./components/Home";
import About from "./components/About";
import { Routes, Route, Link } from "react-router-dom";



function App() {
  return (
    <div className="App">
        <ul>
        <li>
          <Link to="/">HOME</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
      </ul>
      <hr />
      <Routes>
        <Route path="/" element={<Home title="My HOME" />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </div>
  );
}

export default App;
