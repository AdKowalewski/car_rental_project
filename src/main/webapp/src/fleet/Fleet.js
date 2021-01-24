import './Fleet.css';
import React, {useState, useEffect} from "react";
import Header from "../components/header/Header";
import Car from "../components/car/Car";
import Footer from "../components/footer/Footer";
 import { Range } from 'rc-slider';
import 'rc-slider/assets/index.css';
import { Form } from 'react-bootstrap';
import filter from "../assets/appImages/icons8-filter-64.png"
import i18n from "../i18n/i18n";
const Fleet=()=> {

    const [price,setPrice]=useState([0,10]);
    const [horsePower,setHorsePower]=useState([0,10]);
    const [numberOfSeats,setNumberOfSeats]=useState([0,7]);
    const [numberOfDoors,setNumberOfDoors]=useState([0,7]);
    const [yearOfProduction,setYearOfProduction]=useState([1995,2020]);
    const [isFilter,setIsFilters] = useState(false);

    const [isLoaded, setIsLoaded] = useState(false);
    const [cars, setAllCars] = useState(null);

    useEffect( ()=>{
        async function getAllCars (){
            await fetch("http://localhost:8080/api/cars")
                .then(res => res.json())
                .then(
                    (result) => {
                        setAllCars(result);
                        console.log(result)
                    },
                ).catch((err)=>console.log(err))
        }
        getAllCars().then(()=>setIsLoaded(true));

    },[])
    
    return (
        <div className={"fontFamily"}>
            <div className={"containerScreen"} >
            <Header />
            <div className={"containerWidth"}>
                <div className={"title"}>
                    <div className={"filterName"}>{i18n.t("fleet")}</div>
                    <img className={"filter"} src={filter} onClick={()=>{setIsFilters(prevState=>!prevState)}}/>
                </div>
                {isFilter &&
                <div className={"filters"}>
                    Price
                    <Range min={0} max={100} defaultValue={[0, 10]}
                           onChange={(selectedPrice) => setPrice(selectedPrice)}/>
                    <text>{price[0]} {price[1]}</text><br></br><br></br>
                    Horse Power
                    <Range min={0} max={100} defaultValue={[0, 10]}
                           onChange={(selectedPower) => setHorsePower(selectedPower)}/>
                    <text>{horsePower[0]} {horsePower[1]}</text><br></br><br></br>
                    Number of seats
                    <Range min={3} max={7} defaultValue={[3, 7]}
                           onChange={(numberOfDoors) => setNumberOfDoors(numberOfDoors)}/>
                    <text>{numberOfDoors[0]} {numberOfDoors[1]}</text><br></br><br></br>
                    Number of doors
                    <Range min={3} max={7} defaultValue={[3, 7]}
                           onChange={(numberOfSeats) => setNumberOfSeats(numberOfSeats)}/>
                    <text>{numberOfSeats[0]} {numberOfSeats[1]}</text><br></br><br></br>
                    Year of production
                    <Range min={1995} max={2020} defaultValue={[1995, 2020]}
                           onChange={(yearOfProduction) => setYearOfProduction(yearOfProduction)}/>
                    <text>{yearOfProduction[0]} {yearOfProduction[1]}</text><br></br><br></br>
                    <p>Fuel Type</p>
                    <Form>
                        {['checkbox'].map((type) => (
                            <div key={`inline-${type}`} className="mb-3"
                                 style={{display: "flex", flexDirection: "row"}}>
                                <Form.Check inline label="Petrol" type={type} id={`inline-${type}-1`}/>
                                <Form.Check inline label="Diesel" type={type} id={`inline-${type}-2`}/>
                            </div>
                        ))}
                    </Form>
                    <p>Gearbox Type</p>
                    <Form>
                        {['checkbox'].map((type) => (
                            <div key={`inline-${type}`} className="mb-3"
                                 style={{display: "flex", flexDirection: "row"}}>
                                <Form.Check inline label="Manual" type={type} id={`inline-${type}-1`}/>
                                <Form.Check inline label="Automatic" type={type} id={`inline-${type}-2`}/>
                            </div>
                        ))}
                    </Form>
                    <p>Air conditioner</p>
                    <Form>
                        {['checkbox'].map((type) => (
                            <div key={`inline-${type}`} className="mb-3"
                                 style={{display: "flex", flexDirection: "row"}}>
                                <Form.Check inline label="Manual" type={type} id={`inline-${type}-1`}/>
                                <Form.Check inline label="Automatic" type={type} id={`inline-${type}-2`}/>
                            </div>
                        ))}
                    </Form>
                    <input className={"button"} type="submit" value={i18n.t("submit")} />
                </div>
                }

            <div className={"carsList"}>
                {isLoaded&&cars.map((item,index)=>{
                    return <Car key={index} brand={item.brand} model={item.model} horsePower={item.horsePower}
                    fuelType={item.fuelType} numberOfDoors={item.numberOfDoors} numberOfSeats={item.numberOfSeats}
                    dailyFee={item.dailyFee} year={item.year} manual={item.manual} hasAc={item.hasAc} photo={item.photos[0].url}/>
                })}

            {/*<Car/>*/}
            {/*<Car/>*/}
            {/*<Car/>*/}
            </div>
            </div>
            <Footer/>
            </div>
        </div>
    );
}

export default Fleet;
