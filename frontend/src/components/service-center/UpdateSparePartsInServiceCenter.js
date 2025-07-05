import React, { useState } from 'react';
import axios from 'axios';

const UpdateSparePartsInServiceCenter = () => {
  const [updatingParts, setUpdatingParts] = useState(false);
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

  const handleUpdateParts = async () => {
    try {
      const payload = {
        serviceCenterId: parseInt(serviceCenterId, 10), // Convert to integer
        zoneId: parseInt(zoneId, 10), // Convert to integer
        sparePartsInServiceCenter,
      };

      const response = await axios.put('http://localhost:8080/v1/spareParts/ServiceCenter/update.json', payload);

      console.log(response.data); // Handle response as needed

      // Clear input fields after successful update
      setServiceCenterId('');
      setZoneId('');
      setSparePartsInServiceCenter({});
      setUpdatingParts(false); // Reset the state for next update
    } catch (error) {
      console.error(error);
    }
  };

  const handleStartUpdatingParts = () => {
    setUpdatingParts(true);
    setServiceCenterId('');
    setZoneId('');
    setSparePartsInServiceCenter({});
  };

  return (
    <div>
      <h2>Update Spare Parts in Service Center</h2>
      {!updatingParts ? (
        <div>
          <p>Do you want to update spare parts in the service center?</p>
          <button onClick={handleStartUpdatingParts}>Yes</button>
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
            <button type="button" onClick={handleUpdateParts}>
              Update Spare Parts
            </button>
            <p>The Part Name should be entered as "modelname_partname" for eg. "y1_camera"</p>
          </form>
        </div>
      )}
    </div>
  );
};

export default UpdateSparePartsInServiceCenter;
