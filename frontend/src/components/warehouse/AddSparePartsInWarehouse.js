import React, { useState } from 'react';
import axios from 'axios';
const AddSpareParts = () => {

  const [zoneID, setZoneID] = useState('');
  const [zone, setZone] = useState('');
  const [partName, setPartName] = useState('');
  const [quantity, setQuantity] = useState('');
  const [spareParts, setSpareParts] = useState({});
  const [addingParts, setAddingParts] = useState(false);

  const handlePartNameChange = (e) => {
    setPartName(e.target.value);
  };

  const handleQuantityChange = (e) => {
    setQuantity(e.target.value);
  };

  const handleAddPart = () => {
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

      const response = await axios.post('http://localhost:8080/v1/spareParts/Warehouse/add.json', payload);

      console.log(response.data); // Handle response as needed

      // Clear input fields after successful submission
      setZoneID('');
      setZone('');
      setSpareParts({});
      setAddingParts(false); // Reset the state for next part addition
    } catch (error) {
      console.error(error);
    }
  };

  const handleStartAddingParts = () => {
    setAddingParts(true);
    setZoneID('');
    setZone('');
    setSpareParts({});
  };

  return (

    <div>
      <h2>Add Spare Parts in Warehouse</h2>
      {!addingParts ? (
        <div>
          <p>Do you want to add spare parts to the warehouse?</p>
          <button onClick={handleStartAddingParts}>Yes</button>
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
            <button type="button" onClick={handleAddPart}>
              Add Part
            </button>
          </div>
          {Object.keys(spareParts).map((partName) => (
            <div key={partName}>
              {partName}: {spareParts[partName]}
            </div>
          ))}
          <button type="submit">Add Spare Parts</button>
          <p>The Part Name should be entered as "modelname_partname" for eg. "y1_camera"</p>
        </form>
      )}
    </div>
  );
};

export default AddSpareParts;
