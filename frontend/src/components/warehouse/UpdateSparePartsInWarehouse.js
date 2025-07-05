import React, { useState } from 'react';
import axios from 'axios';
const UpdateSpareParts = () => {
  const [zoneID, setZoneID] = useState('');
  const [zone, setZone] = useState('');
  const [partName, setPartName] = useState('');
  const [quantity, setQuantity] = useState('');
  const [spareParts, setSpareParts] = useState({});
  const [updateingParts, setupdateingParts] = useState(false);

  const handlePartNameChange = (e) => {
    setPartName(e.target.value);
  };

  const handleQuantityChange = (e) => {
    setQuantity(e.target.value);
  };

  const handleupdatePart = () => {
    if (partName && quantity) {
      setSpareParts((prevSpareParts) => ({
        ...prevSpareParts,
        [partName]: parseInt(quantity, 10), // Convert to integer
      }));
      setPartName('');
      setQuantity('');
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const payload = {
        zoneID: parseInt(zoneID, 10), // Convert to integer
        zone,
        spareParts,
      };

      const response = await axios.put('http://localhost:8080/v1/spareParts/Warehouse/update.json', payload);

      console.log(response.data); // Handle response as needed

      // Clear input fields after successful submission
      setZoneID('');
      setZone('');
      setSpareParts({});
      setupdateingParts(false); // Reset the state for next part updateition
    } catch (error) {
      console.error(error);
    }
  };

  const handleStartupdateingParts = () => {
    setupdateingParts(true);
    setZoneID('');
    setZone('');
    setSpareParts({});
  };

  return (
    <div>
   
      <h2>Update Spare Parts in Warehouse</h2>
      {!updateingParts ? (
        <div>
          <p>Do you want to update spare parts to the warehouse?</p>
          <button onClick={handleStartupdateingParts}>Yes</button>
        </div>
      ) : (
        <form onSubmit={handleSubmit}>
          <input
            type="number"
            placeholder="Zone ID"
            value={zoneID}
            onChange={(e) => setZoneID(e.target.value)}
          />
          <input
            type="text"
            placeholder="Zone"
            value={zone}
            onChange={(e) => setZone(e.target.value)}
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
            <button type="button" onClick={handleupdatePart}>
              update Part
            </button>
          </div>
          {Object.keys(spareParts).map((partName) => (
            <div key={partName}>
              {partName}: {spareParts[partName]}
            </div>
          ))}
          <button type="submit">update Spare Parts</button>
          <p>The Part Name should be entered as "modelname_partname" for eg. "y1_camera"</p>
        </form>
      )}
    </div>
  );
};

export default UpdateSpareParts;
