import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css';

const Home = () => {
  return (
    <div className="container" id="bgimage">
      <div className="header">
        <h1>Welcome to the Spare Parts Management System</h1>
      </div>
      <nav className="btn-container">
        <ul>
          <li><Link className="btn" to="/warehouse">Warehouse</Link></li>
          <li><Link className="btn" to="/service-center">Service Center</Link></li>
          <li><Link className="btn" to="/consumer">Consumer</Link></li>
          <li><Link className="btn" to="/planning-team">Planning Team</Link></li>
        </ul>
      </nav>
      <a href="https://github.com/AbhaySingh7228/Spare-Parts-Management-System" target="_blank" rel="noreferrer">
  <button className="github">Visit GitHub</button>
</a>
    </div>
  );
}

export default Home;
