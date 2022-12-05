import React from 'react'
import { useState } from 'react';
import axios from 'axios';
 import { useNavigate } from 'react-router-dom';
import './Home.css';



function Home() {
  const navigate = useNavigate();
  const [city, setcity] = useState('');


  const handleSubmit = async (e) => {
    e.preventDefault();
    e.target.reset();
    console.log(city);
    // obj1 = {
    //   city: city
    // }
    // console.log(obj1);
    axios
      .put(`https://623c81188e9af58789521b88.mockapi.io/data/1`, {
        city: city
      })
      .then((res) => {
        console.log(res);
        console.log(res.data);
      });
      navigate('/weather');

  }




  return (
    <section>

      
      <form className='form' onSubmit={handleSubmit}>
      <h2 className='text-center'>Weather WEB Application</h2>
        <div className='form-row'>
          <label htmlFor='name' className='form-label'>
            Enter City Name*
          </label>
          <input
            type='text'
            className='form-input'
            id='name'
            value={city}
            onChange={(e) => setcity(e.target.value)}
          />
        </div>
        {/* <Link to='weather'>  */}
        <button type='submit' className='btn btn-block'>
          Search
        </button>
        {/* </Link> */}
      </form>


    </section>

    // <div className='home' onSubmit={responese}>
    //     <label className='home-label'>Enter City *</label>
    //     <input type="text" placeholder='Enter your city' required></input>

    // </div>

  )
}
export default Home