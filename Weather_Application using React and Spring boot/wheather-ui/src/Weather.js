
import React, { useEffect, useState } from 'react'
import { Link } from "react-router-dom";
import axios from 'axios';
import './Weather.css';
import image1 from './images/1.png'
import image5 from './images/5.png'
import image3 from './images/3.png'

function Weather() {
  // const [users, setUsers] = useState([]);
  // // const axios = require('axios');

  // useEffect(() => {
  //   axios('/API/list', {
  //     method: "GET",
  //     headers: {
  //       "access-control-allow-origin": "*",
  //       "Content-type": "application/json; charset=UTF-8"
  //     }
  //   })

  //     .then(function (response) {
  //       // console.log(response.data.api);
  //       setUsers(response.data.api);
  //       // console.log("usres"+users.base);
  //       // console.log("usres"+users.main);
  //       // (response.data);
  //     })
  //     .catch(function (error) {
  //       console.log(error);
  //       console.log("error");
  //     });

  const [loading, setLoading] = useState(true);
  const [data, setData] = useState([])

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const { data: response } = await axios.get('/API/list');
        setData(response);
      } catch (error) {
        console.error(error.message);
      }
      setLoading(false);
    }

    fetchData();
  }, []);





  // console.log("data " + data.api);
  // -273.15
  // var temp=users.main.temp
  // }, []);
  // var Temperature =data.api.main.temp-273.15;



  return (

    <div className='main-container'>
      <div className='container'>
        <div>
          <Link to="/">
            <button type='submit'>Back to Main</button>
          </Link>
        </div>
        {/* {users.base}
        <br />
        {users.main.temp - 273.15} */}
        {loading && <div>Loading</div>}
        {!loading && (
          <>
            <h2>Weather in {data.api.name}</h2>
            <div className='card'>
              <div className='Temperature'>

                <img className='image1' src={image1} alt=""></img>
                <div>
                  <h3 className='text'>Temperature :  {(data.api.main.temp - 273.15).toFixed(2)} </h3>
   
                  <h6>Temperature-min :  {(data.api.main.temp_min - 273.15).toFixed(2)} </h6>
                  <h6> Temperature-max :  {(data.api.main.temp_max - 273.15).toFixed(2)}</h6>
                </div>
              </div>
              <div className='Temperature'>

                <img className='image1' src={image3} alt=""></img>
                <div>
                  <h3 className='text'>Wind Speed :  {data.api.wind.speed} </h3>
 
                  <h6>Pressure : {data.api.main.pressure } </h6>
                  <h6>Humidity : {data.api.main.humidity}</h6>
                </div>
              </div>

              <div className='Temperature'>

                <img className='image5' src={image5} alt=""></img>
                <div>
                  <h3 className='text'>Location </h3>
 
                  <h6>Latitude  : {data.api.coord.lat } </h6>
                  <h6>Longitude : {data.api.coord.lon}</h6>
                </div>
              </div>

            </div>
          </>
        )}


      </div>

    </div>

  )
}

export default Weather