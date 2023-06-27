import { useParams } from "react-router-dom"



function PersonalAccount(){
    const param = useParams()

    return (
        <div>PersonalAccount id#{param.userId}</div>
    )
}

export {PersonalAccount}