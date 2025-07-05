import React from 'react';
import {
  // eslint-disable-next-line
  BrowserRouter as Router,
  Routes,
  Route
} from 'react-router-dom';
import Home from './Home';
import WarehousePage from './WarehousePage';
import ServiceCenterPage from './ServiceCenterPage';
import ConsumerPage from './ConsumerPage';
import PlanningTeamPage from './PlanningTeamPage';
import './App.css';
const App = () => {
  return (
    // <Router>
       <div>
        <Routes>
          <Route path="/" element={<Home />} />

          <Route path='/warehouse/*' element={<WarehousePage />} />

          <Route path='/service-center/*' element={<ServiceCenterPage />} />

          <Route path='/consumer/*' element={<ConsumerPage />} />

          <Route path='/planning-team/*' element={<PlanningTeamPage />} />
        </Routes>
     </div>
    // </Router>
  );
};

export default App;
