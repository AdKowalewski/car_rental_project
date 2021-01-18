import './App.css';
import React from "react";
import Header from "../components/header/Header";
import tank_background from "../assets/appImages/tank_background.png";
import tankPower from "../assets/appImages/tank_power.png";
import branches from "../assets/appImages/map.png";
import fleet from "../assets/appImages/flota.jpg";
import fastCar from "../assets/carImages/BI09a.jpg";
import elegantCar from "../assets/carImages/BI13b.jpg";

import SearchBar from "../components/searchBar/searchBar";
import i18n from "../i18n/i18n"
import Footer from "../components/footer/Footer";

const App=()=> {
    return (<div className={"fontFamily"}>
            <Header />
            <SearchBar />
            <div className={"backgroundColor"}>
                <img className={"image"} src={tank_background} alt={"tank_background"}/>
            <div className={"textBestRental"}>
                {i18n.t("bestRentalText")}
            </div>
            <div className={"containerCards"}>
                <div className={"imagesContainer"}>
                    <div className={"imagesText"}>{i18n.t("branches")}</div>
                    <img className={"imageCardRectangle"}  src={branches} alt={"branches"}/>
                </div>
                <div className={"imagesContainer"}>
                    <div className={"imagesText"}>{i18n.t("fleet")}</div>
                    <img className={"imageCardRectangle"} src={fleet} alt={"branches"}/>
                </div>
            </div>
            </div>
            <div className={"textOffers"}>
                {i18n.t("mostPopularOffers")}
            </div>
            <div className={"containerCards"}>
                <div style={{display:"flex",flexDirection:"column", alignItems:"center", color:"chocolate"}}>
                    {i18n.t("power")}
                    <img className={"imageCard"} src={tankPower} alt={"tankPower"}/>
                    120 zł/h
                </div>
                <div style={{display:"flex",flexDirection:"column", alignItems:"center", color:"chocolate"}}>
                    {i18n.t("fast")}
                    <img className={"imageCard"} src={fastCar} alt={"fastCar"}/>
                    28 zł/h
                </div>
                <div style={{display:"flex",flexDirection:"column", alignItems:"center", color:"chocolate"}}>
                    {i18n.t("elegance")}
                    <img className={"imageCard"} src={elegantCar} alt={"elegantCar"}/>
                    25 zł/h
                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default App;
