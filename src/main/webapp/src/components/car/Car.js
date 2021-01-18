import  "./Car.css";
import tankPower from "../../assets/appImages/tank_power.png";
import React from "react";
import i18n from "../../i18n/i18n";
import fuel from "../../assets/appImages/icons8-eco-fuel-100.png"
import door from "../../assets/appImages/icons8-car-door-64.png"
import person from "../../assets/appImages/icons8-person-64.png"
import money from "../../assets/appImages/icons8-money-bag-80.png"
import engine from "../../assets/appImages/icons8-engine-64.png"
import calendar from "../../assets/appImages/icons8-calendar-80.png"
import gearbox from "../../assets/appImages/icons8-gearbox-64.png"
import airConditioner from "../../assets/appImages/icons8-air-conditioner-100.png"
// import 'bootstrap/dist/css/bootstrap.min.css';
const Car=({brand,model, horsePower, fuelType, numberOfDoors, numberOfSeats, dailyFee, year, manual, hasAc, photo})=> {

    return (
        <div >
    <div className={"carContainer"}>
      <div className={"carInfo"}>
        <div className={"categoryName"}>
            <h2>{brand} {model}</h2>
        </div>
          <div className={"carIconsContainer"}>
              <div className={"rowCar"}>
          <div className={"category"}>
              <img  className={"icon"} src={fuel}/> {fuelType}
          </div>
          <div className={"category"}>
              <img  className={"icon"} src={door}/> {numberOfDoors}
          </div>
          <div className={"category"}>
              <img  className={"icon"} src={person}/> {numberOfSeats}
          </div>
          <div className={"category"}>
              <img  className={"icon"} src={money}/> {dailyFee} zł/day
          </div>
              </div>
          <div className={"rowCar"}>
              <div className={"category"}>
                  <img  className={"icon"} src={engine}/> {horsePower} HP
              </div>
              <div className={"category"}>
                  <img  className={"icon"} src={calendar}/> {year}
              </div>
              <div className={"category"}>
                  <img  className={"icon"} src={gearbox}/> {manual?"Manual":"Automatic"}
              </div>
              <div className={"category"}>
                  <img  className={"icon"} src={airConditioner}/> {hasAc?"Include":"Not include"}
              </div>
          </div>
          </div>
      </div>
        <div className={"carImage"}>
        <img className={"imageCard"} src={photo} alt={"tankPower"} onLoad={console.log("load")}/>
        </div>
</div>
            <div className={"carContainer2"}>
                <input className={"buttonFleet"} type="submit" value={i18n.t("RESERVE")} />
            </div>

        </div>
    )
}

export default Car;