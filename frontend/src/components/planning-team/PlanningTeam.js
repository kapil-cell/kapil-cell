import React, { useState } from 'react';
import axios from 'axios';

const PlanningTeam = () => {
  const [planningParts, setPlanningParts] = useState(false);
  const [serviceCenterId, setServiceCenterId] = useState('');
  const [zoneId, setZoneId] = useState('');
  const [partName, setPartName] = useState('');
  const [quantity, setQuantity] = useState('');
  const [sparePartsInServiceCenter, setSparePartsInServiceCenter] = useState({});

  const handlePartNameChange = (e) => {
    setPartName(e.target.value);
  };

  const handleQuantityChange = (e) => {
    setQuantity(e.target.value);
  };

  const handleAddPart = () => {
    if (partName && quantity) {
      setSparePartsInServiceCenter((prevSpareParts) => ({
        ...prevSpareParts,
        [partName]: parseInt(quantity, 10), // Convert to integer
      }));
      setPartName('');
      setQuantity('');
    }
  };

  const handlePlanParts = async () => {
    try {
      const payload = {
        serviceCenterId: parseInt(serviceCenterId, 10), // Convert to integer
        zoneId: parseInt(zoneId, 10), // Convert to integer
        sparePartsInServiceCenter,
      };

      const response = await axios.post('http://localhost:8080/v1/spareParts/Planning.json', payload);

      console.log(response.data); // Handle response as needed

      // Clear input fields after successful planning
      setServiceCenterId('');
      setZoneId('');
      setSparePartsInServiceCenter({});
      setPlanningParts(false); // Reset the state for next planning
    } catch (error) {
      console.error(error);
    }
  };

  const handleStartPlanningParts = () => {
    setPlanningParts(true);
    setServiceCenterId('');
    setZoneId('');
    setSparePartsInServiceCenter({});
  };

  return (
    <div>
      <h2>Planning Team - Plan Spare Parts for Service Center</h2>
      {!planningParts ? (
        <div>
          <p>Does the service center want to plan for spare parts?</p>
          <button onClick={handleStartPlanningParts}>Yes</button>
        </div>
      ) : (
        <div>
          <form>
            <input
              type="number"
              placeholder="Service Center ID"
              value={serviceCenterId}
              onChange={(e) => setServiceCenterId(e.target.value)}
            />
            <input
              type="number"
              placeholder="Zone ID"
              value={zoneId}
              onChange={(e) => setZoneId(e.target.value)}
            />
            <div>
              <input
                type="text"
                placeholder="Part Name"
                value={partName}
                onChange={handlePartNameChange}
              />
              <input
                type="number"
                placeholder="Quantity"
                value={quantity}
                onChange={handleQuantityChange}
              />
              <button type="button" onClick={handleAddPart}>
                Add Part
              </button>
            </div>
            {Object.keys(sparePartsInServiceCenter).map((partName) => (
              <div key={partName}>
                {partName}: {sparePartsInServiceCenter[partName]}
              </div>
            ))}
            <button type="button" onClick={handlePlanParts}>
              Plan Spare Parts
            </button>
            <p>The Part Name should be entered as "modelname_partname" for eg. "y1_camera"</p>
          </form>
        </div>
      )}
    </div>
  );
};

export default PlanningTeam;
