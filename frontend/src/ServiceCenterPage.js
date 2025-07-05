import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import AddSparePartsInServiceCenter from './components/service-center/AddSparePartsInServiceCenter';
import UpdateSparePartsInServiceCenter from './components/service-center/UpdateSparePartsInServiceCenter';
import GetInfoFromServiceCenter from './components/service-center/GetInfoFromServiceCenter';
import './Home.css';
const ServiceCenterPage = () => {
  return (
    <div className='container' id='service-bg'>
      <div className='partsheader'>
      <h2>Service Center</h2>
      </div>
      <nav>
      <Link className='home' to="/">Home</Link>
     
          <Link className='partsbtn' to="add">Add Spare Parts</Link>
          <Link className='partsbtn' to="update">Update Spare Parts</Link>
          <Link className='partsbtn' to="info">Get Info</Link>
    
      </nav>
      <Routes>
        <Route path="add" element={<AddSparePartsInServiceCenter />} />
        <Route path="update" element={<UpdateSparePartsInServiceCenter />} />
        <Route path="info" element={<GetInfoFromServiceCenter />} />
        {/* <Route path="/" element={<Home />} /> */}
      </Routes>
    </div>
  );
};

export default ServiceCenterPage;
