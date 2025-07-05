import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import AddSparePartsInWarehouse from './components/warehouse/AddSparePartsInWarehouse';
import UpdateSparePartsInWarehouse from './components/warehouse/UpdateSparePartsInWarehouse';
import GetInfoFromWarehouse from './components/warehouse/GetInfoFromWarehouse';
import './Home.css';

const WarehousePage = () => {
  return (
    <div className='container' id='warehouse-bg'>
      <div className='partsheader'>

      <h2>Warehouse</h2>
      </div>
      <nav>
      <Link className='home' to="/">Home</Link>

          <Link className='partsbtn' to="add">Add Spare Parts</Link>
          <Link className='partsbtn' to="update">Update Spare Parts</Link>
         <Link className='partsbtn' to="info">Get Info</Link>

      </nav>

      <Routes>
        <Route path="add" element={<AddSparePartsInWarehouse />} />
        <Route path="update" element={<UpdateSparePartsInWarehouse />} />
        <Route path="info" element={<GetInfoFromWarehouse />} />
        {/* <Route path="/" element={<Home />} /> */}
      </Routes>
    </div>
  );
};

export default WarehousePage;
