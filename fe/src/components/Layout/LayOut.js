import React from 'react';

import { useLocation } from 'react-router-dom';
import { Header } from '../Header';

const Layout = ({ children }) => {
  const router = useLocation();

  const { pathname } = router;
  const noHeader = ['/login'];

  return (
    <div>
      <div className="flex flex-col h-screen">
        {noHeader.includes(pathname) ? null : <Header />}
        <main className="mb-auto">{children}</main>

      </div>
    </div>
  );
};

export default Layout;