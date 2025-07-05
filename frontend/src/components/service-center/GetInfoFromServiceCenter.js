import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ServiceCenterInfo = () => {
  const [serviceCenterInfo, setServiceCenterInfo] = useState([]);
  const [showInfo, setShowInfo] = useState(false);

  useEffect(() => {
    if (showInfo) {
      async function fetchServiceCenterInfo() {
        try {
          const response = await axios.get('http://localhost:8080/v1/spareParts/ServiceCenter.json');
          setServiceCenterInfo(response.data.serviceCenterList);
        } catch (error) {
          console.error(error);
        }
      }

      fetchServiceCenterInfo();
    }
  }, [showInfo]);

  const handleToggleInfo = () => {
    setShowInfo(!showInfo);
  };

  return (
    <div>
      <h2>Service Center Information</h2>
      <button onClick={handleToggleInfo}>
        {showInfo ? 'Hide Info' : 'Show Info'}
      </button>
      {showInfo && (
        <div>
          {serviceCenterInfo.map((center, index) => (
            <div key={index}>
              <h3>Service Center {center.serviceCenterId}</h3>
              <p>Zone ID: {center.zoneId}</p>
              <p>Spare Parts:</p>
              <ul>
                {Object.keys(center.sparePartsInServiceCenter).map((partName) => (
                  <li key={partName}>
                    {partName}: {center.sparePartsInServiceCenter[partName]}
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

export default ServiceCenterInfo;
