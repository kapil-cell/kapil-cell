import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import PlanningTeam from './components/planning-team/PlanningTeam';
import './Home.css';
const PlanningTeamPage = () => {
  return (
    <div className='container' id='planning-bg'>
      <div className='partsheader'>
      <h2>Planning Team</h2>
      </div>
      <nav>
      <Link className='home' to="/">Home</Link>

          <Link className='partsbtn' to="plan">Plan Spare Parts</Link>
      </nav>
      <Routes>
        <Route path="plan" element={<PlanningTeam />} />
        {/* <Route path="/" element={<Home />} /> */}
      </Routes>
    </div>
  );
};

export default PlanningTeamPage;
