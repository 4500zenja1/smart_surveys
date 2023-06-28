import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input, Typography,Card } from 'antd';
import { useNavigate } from 'react-router-dom';
const {Title,Text} = Typography;

const Login = () => {
    let navigate = useNavigate();
  const onFinish = (values) => {
    console.log('Received values of form: ', values);
    let path = '/home';
    navigate(path)
    };
  return (
    <div 
      style={{
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      height: "100vh",
    }}>
    <Card style = {{width: 500}}>

    <Form
      name="normal_login"
      className="login-form"
      initialValues={{
        remember: true,
      }}
      onFinish={onFinish}
    >
        <Form.Item >
        <Title level = {2}>Smart Survey</Title>
        <Text type = "secondary">The SMARTEST survey creation tool</Text>
        </Form.Item>
        
      <Form.Item
        name="username"
        rules={[
          {
            required: true,
            message: 'Please input your Username!',
          },
        ]}
      >
        <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Username" />
      </Form.Item>
      <Form.Item
        name="password"
        rules={[
          {
            required: true,
            message: 'Please input your Password!',
          },
        ]}
      >
        <Input.Password
          prefix={<LockOutlined className="site-form-item-icon" />}
          type="password"
          placeholder="Password"
        />
      </Form.Item>
      <Form.Item>
        <Button type="primary" htmlType="submit" className="login-form-button">
          Log in
        </Button>
      </Form.Item>
    </Form>
        </Card>
 
    </div>
  
  );
};

export {Login};
