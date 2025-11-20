import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <div>
      <p>This is our layout</p>
      <ul>
        <li>
          <a href="/work">Work</a>
        </li>
        <li>
          <a href="/home">Home</a>
        </li>
      </ul>
      <Outlet />{" "}
      {/* <Outlet /> is needed to provide nested routes inside of x route */}
    </div>
  );
};

export default Layout;
