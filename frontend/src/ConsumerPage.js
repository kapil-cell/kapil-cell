import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import ConsumeFromServiceCenter from './components/consumer/ConsumeFromServiceCenter';
import './Home.css';
const ConsumerPage = () => {
  return (
    <div className='container' id='consumer-bg'>
      <div className='partsheader'>
      <h2>Consumer</h2>
      </div>
      <nav>
      <Link className='home' to="/">Home</Link>

          <Link className='partsbtn' to="consume">Consume Spare Parts</Link>

      </nav>
      <Routes>
        <Route path="consume" element={<ConsumeFromServiceCenter />} />
        {/* <Route path="/" element={<Home />} /> */}
      </Routes>
    </div>
  );
};

export default ConsumerPage;
