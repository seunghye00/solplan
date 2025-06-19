import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Admin = () => {

  const navigate = useNavigate();

    useEffect(() => {
      const userId = localStorage.getItem('userId');
      const role = localStorage.getItem('role');
      if (!userId && role != 'ADMIN') {
        alert('잘못된 접근입니다.');
        navigate('/');
      }
    }, []);

  return (
    <div style={{ maxWidth: 500, margin: '50px auto' }}>
      <h2>관리자 페이지</h2>
      <button onClick={() => navigate('/')}>
        뒤로가기
      </button>
    </div>
  );
};

export default Admin;