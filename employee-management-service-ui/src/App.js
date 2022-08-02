import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import './App.css';
import AddEmployee from './components/AddEmployee';
import EmployeeList from './components/EmployeeList';
import UpdateEmployee from './components/UpdateEmployee';
import NavBar from './components/NavBar';

function App() {
  return( 
  <>
  <Router>
    <NavBar />
    <Routes>
      <Route index element={<EmployeeList />}/>
      <Route path="/" element={<EmployeeList />}/>
      <Route path="/employeeList" element={<EmployeeList />}/>
      <Route path="/addEmployee" element={<AddEmployee />}/>
      <Route path="/updateEmployee/:id" element={<UpdateEmployee />}/>
    </Routes>
  </Router>
  </>);
}

export default App;
