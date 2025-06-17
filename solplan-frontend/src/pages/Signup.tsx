import SignupForm from '../components/SignupForm';
import { useNavigate } from 'react-router-dom';

const Signup = () => {

  const navigate = useNavigate();

  return (
    <div style={{ maxWidth: 500, margin: '50px auto' }}>
      <h2>회원가입</h2>
      <SignupForm />
      <button onClick={() => navigate('/')}>
        뒤로가기
      </button>
    </div>
  );
};

export default Signup;