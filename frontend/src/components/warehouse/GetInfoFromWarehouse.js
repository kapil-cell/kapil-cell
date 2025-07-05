import React, { useState } from 'react';
import axios from 'axios';
const WarehouseInfo = () => {
  const [showInfo, setShowInfo] = useState(false);
  const [warehouseInfo, setWarehouseInfo] = useState([]);

  const toggleInfo = async () => {
    if (!showInfo) {
      try {
        const response = await axios.get('http://localhost:8080/v1/spareParts/Warehouse.json');
        setWarehouseInfo(response.data.warehouseList);
      } catch (error) {
        console.error(error);
      }
    }
    setShowInfo(!showInfo);
  };

  return (
    <div>
         
      <h2>Warehouse Information</h2>
      <button onClick={toggleInfo}>{showInfo ? 'Hide Info' : 'Show Info'}</button>
      {showInfo && (
        <div>
          {warehouseInfo.map((warehouse) => (
            <div key={warehouse.warehouseID}>
              <h3>Warehouse ID: {warehouse.warehouseID}</h3>
              <p>Zone ID: {warehouse.zoneID}</p>
              <p>Zone: {warehouse.zone}</p>
              <p>Spare Parts:</p>
              <ul>
                {Object.entries(warehouse.spareParts).map(([partName, quantity]) => (
                  <li key={partName}>
                    {partName}: {quantity}
                  </li>
                ))}
              </ul>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default WarehouseInfo;
